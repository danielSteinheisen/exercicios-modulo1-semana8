package br.com.exercicios.modulo1semana8.service;

import br.com.exercicios.modulo1semana8.model.AlunoModel;
import br.com.exercicios.modulo1semana8.model.CursoModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoService {

    private final AlunoService alunoService;

    public CursoService(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    public List<CursoModel> buscarTodos() {
        return CursoModel.getCursos();
    }
    public CursoModel buscarPorId(Integer id ) throws Exception {
        return CursoModel.buscarPorId(id);
    }

    public CursoModel salvar(CursoModel curso) throws Exception {
        if (validar(curso)) {
            return CursoModel.inserir(curso);
        }
        return null;
    }

    public CursoModel matricular(Integer id, Integer alunoId) throws Exception {
        CursoModel curso = buscarPorId(id);
        AlunoModel aluno = alunoService.buscarPorId(alunoId);
        CursoModel.matricular(curso, aluno);
        return curso;
    }

    private boolean validar(CursoModel curso) throws Exception {
        if (curso.getNome() == null || curso.getNome().isBlank()) {
            throw new Exception("Nome é obrigatório!");
        }
        if (curso.getCargaHoraria() == null) {
            throw new Exception("Carga horária é obrigatório!");
        }
        if (curso.getDescricao() == null || curso.getDescricao().isBlank()) {
            throw new Exception("Descrição é obrigatório!");
        }
        return true;
    }
}
