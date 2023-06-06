package com.example.shadow_project.entity.Announcment;

import com.example.shadow_project.entity.Project.Project;
import com.example.shadow_project.entity.User.UserRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AnnouncementServiceImpl implements AnnouncementService{
    @Autowired
    private AnnouncementRepo announcementRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private EntityManager entityManager;

    @Override
    public Announcement uploadAnnouncement(AnnouncementDto announcementDto) {
        modelMapper.typeMap(AnnouncementDto.class, Announcement.class).addMappings(
                mapper-> mapper.map(announcementDto1->userRepo.getUserByUserName(announcementDto.getOwner()),Announcement::setOwner)
        );

        Announcement announcement = modelMapper.map(announcementDto,Announcement.class);
        Announcement savedAnnouncement = announcementRepo.save(announcement);

        return savedAnnouncement;
    }

    @Override
    public Announcement getAnnouncement(Long id) {
        Announcement announcement = announcementRepo.getById(id);
        return announcement;
    }

    @Override
    public List<Announcement> top6Announcements() throws Exception {
        TypedQuery<Announcement> query = entityManager.createQuery("SELECT a FROM Announcement a ORDER BY a.uploadedOn DESC", Announcement.class);
        query.setMaxResults(6);
        List<Announcement> announcementList = query.getResultList();
        if(announcementList==null || announcementList.size()==0){
            throw new Exception("There are no latest Announcements");
        }
        return announcementList;
    }

    @Override
    public List<Announcement> latestAnnouncement() throws Exception {

        // this will fetch the date that was 30 days ago
        Date thirtyDaysAgo = new Date(System.currentTimeMillis() - 30 * 24 * 60 * 60 * 1000);

        Query query = entityManager.createQuery("select a from Announcement a where a.uploadedOn >= :thirtyDaysAgo");
        query.setParameter("thirtyDaysAgo",thirtyDaysAgo);
        List<Announcement> announcementList = query.getResultList();
        if(announcementList==null || announcementList.size()==0){
            throw new Exception("There are no latest Announcements");
        }
        return announcementList;
    }

    @Override
    public List<Announcement> getAllAnnouncements(int pageNumber,int pageSize) {

        Pageable pageable = PageRequest.of(pageNumber,pageSize);
        Page<Announcement> announcementPage = this.announcementRepo.findAll(pageable);
        List<Announcement> announcementList = announcementPage.getContent();
        return announcementList;

    }


}
