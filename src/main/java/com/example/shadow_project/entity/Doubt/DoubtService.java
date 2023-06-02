package com.example.shadow_project.entity.Doubt;

public interface DoubtService {

    Doubt uploadDoubt(DoubtDto doubtDto);

    Doubt getDoubt(Long id);
}
