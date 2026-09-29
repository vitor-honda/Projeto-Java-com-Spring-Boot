package com.eletronico.cadastro_eletronico.infrastructure.repositories;

import com.eletronico.cadastro_eletronico.infrastructure.entitys.Eletronico;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EletronicoRepository extends JpaRepository<Eletronico, Integer> {
    Optional<Eletronico> findByCor(String cor);

    @Transactional
    void deleteByCor(String cor);
}
