package br.com.exercicios.modulo1semana8.service;

import br.com.exercicios.modulo1semana8.model.AlunoModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    public List<AlunoModel> buscarTodos() {
        return AlunoModel.getAlunos();
    }
    public AlunoModel buscarPorId(Integer id) throws Exception {
        return AlunoModel.buscarPorId(id);
    }

    public AlunoModel salvar(AlunoModel aluno) throws Exception {
        if (validar(aluno)) {
            return AlunoModel.inserir(aluno);
        }
        return null;
    }

    private boolean validar(AlunoModel aluno) throws Exception {
        if (aluno.getNome() == null || aluno.getNome().isBlank()) {
            throw new Exception("O nome é obrigatório");
        }
        if (aluno.getDataNascimento() == null) {
            throw new Exception("Data de nascimento é obrigatório");
        }
        return true;
    }
}
