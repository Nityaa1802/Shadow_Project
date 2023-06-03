package com.example.shadow_project.entity.Doubt;
import com.example.shadow_project.entity.Answer.AnswerDto;
import com.example.shadow_project.entity.Answer.Answers;
import com.example.shadow_project.entity.User.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DoubtServiceImpl implements DoubtService {
    @Autowired
    private DoubtRepo doubtRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

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
}
