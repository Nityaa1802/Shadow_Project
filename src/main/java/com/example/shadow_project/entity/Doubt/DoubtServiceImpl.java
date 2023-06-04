package com.example.shadow_project.entity.Doubt;
import com.example.shadow_project.entity.Answer.AnswerDto;
import com.example.shadow_project.entity.Answer.Answers;
import com.example.shadow_project.entity.User.UserRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DoubtServiceImpl implements DoubtService {
    @Autowired
    private DoubtRepo doubtRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private EntityManager entityManager;

    @Override
    public Doubt uploadDoubt(DoubtDto doubtDto){
        modelMapper.typeMap(DoubtDto.class, Doubt.class).addMappings(
                mapper-> mapper.map(doubtDto1->userRepo.getUserByUserName(doubtDto.getAskedBy()),Doubt::setAskedBy)
        );
        Doubt doubt = modelMapper.map(doubtDto,Doubt.class);
        Doubt savedDoubt = doubtRepo.save(doubt);

        return savedDoubt;
    }
    @Override
    public Doubt getDoubt(Long id) {
        Doubt doubt = doubtRepo.getById(id);
        return doubt;
    }

    @Override
    public Doubt uploadAns(Long doubtId, AnswerDto answersDto) {
        Doubt doubt = getDoubt(doubtId);
        modelMapper.typeMap(AnswerDto.class, Answers.class).addMappings(
                mapper-> mapper.map(answersDto1->userRepo.getUserByUserName(answersDto.getReplier()),Answers::setReplier)
        );
        Answers answers = modelMapper.map(answersDto, Answers.class);
        if(doubt.getAnswersList()==null && doubt.getAnswersList().size()==0){
            Set<Answers> answersList = new HashSet<>();
            answersList.add(answers);
            doubt.setAnswersList(answersList);
        }
        else{
            doubt.getAnswersList().add(answers);
        }

        Doubt updatedAnswerDoubt = doubtRepo.save(doubt);
        return updatedAnswerDoubt;

    }

    @Override
    public List<Doubt> top6Doubts() throws Exception {
        TypedQuery<Doubt> query = entityManager.createQuery("SELECT d FROM Doubt d ORDER BY d.uploadedOn DESC", Doubt.class);
        query.setMaxResults(6);
        List<Doubt> doubts = query.getResultList();
        if(doubts==null || doubts.size()==0){
            throw new Exception("There no Doubts Present at this point");
        }
        return doubts;
    }

}
