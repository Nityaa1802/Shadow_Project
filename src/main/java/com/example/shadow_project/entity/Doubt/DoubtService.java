package com.example.shadow_project.entity.Doubt;

import com.example.shadow_project.entity.Answer.AnswerDto;

import java.util.List;

public interface DoubtService {

    Doubt uploadDoubt(DoubtDto doubtDto);

    Doubt getDoubt(Long id);

    Doubt uploadAns(Long doubtId , AnswerDto answersDto);

    List<Doubt> top6Doubts() throws Exception;
}
