package com.eletronico.cadastro_eletronico.bussines;

import com.eletronico.cadastro_eletronico.infrastructure.entitys.Eletronico;
import com.eletronico.cadastro_eletronico.infrastructure.repositories.EletronicoRepository;
import org.springframework.stereotype.Service;

@Service
public class EletronicoService {
    private final EletronicoRepository repository;

    public EletronicoService(EletronicoRepository repository) {
        this.repository = repository;
    }

    public void salvarEletronico(Eletronico eletronico)
    {
        repository.saveAndFlush(eletronico);
    }

    public Eletronico buscarPorCor(String cor)
    {
        return repository.findByCor(cor).orElseThrow(
                () -> new RuntimeException("Cor não encontrada")
        );
    }

    public void deletarEletronicoPorCor(String cor)
    {
        repository.deleteByCor(cor);
    }

    public void atualizarEletronicoPorCor(String cor,Eletronico eletronico)
    {
        Eletronico eletronicoEntity = buscarPorCor(cor);
        Eletronico eletronicoAtualizado = Eletronico.builder()
                .cor(eletronico.getCor() != null ? eletronico.getCor() :
                        eletronicoEntity.getCor())
                .modelo(eletronico.getModelo() != null ? eletronico.getModelo() :
                        eletronicoEntity.getModelo())
                .id(eletronicoEntity.getId())
                .build();
    }

    public void atualizarEletronicoPorId(Integer id, Eletronico eletronico)
    {
        Eletronico eletronicoEntity = repository.findById(id).orElseThrow(() -> new RuntimeException("Eletronico não encontrado"));
    }
}
