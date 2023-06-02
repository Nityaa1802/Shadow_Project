package com.example.shadow_project.entity.Doubt;

import com.example.shadow_project.entity.Announcment.Announcement;
import com.example.shadow_project.entity.Announcment.AnnouncementDto;
import com.example.shadow_project.entity.Announcment.AnnouncementService;
import com.example.shadow_project.entity.User.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
