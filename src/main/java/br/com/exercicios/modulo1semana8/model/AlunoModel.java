package br.com.exercicios.modulo1semana8.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static br.com.exercicios.modulo1semana8.model.CursoModel.getProximoId;

@Data
public class AlunoModel {

    private static Integer proximoId = 1;
    @Getter private static List<AlunoModel> alunos = new ArrayList<>();

    @Setter(AccessLevel.NONE) private Integer id;
    private String nome;
    private LocalDate dataNascimento;

    private Integer getPrximoId() {
        return proximoId ++;

    }

    public static AlunoModel inserir(AlunoModel aluno) {
        aluno.id = getProximoId();
        alunos.add(aluno);
        return aluno;
    }
    public static AlunoModel buscarPorId(Integer id) throws Exception {
        for (AlunoModel aluno : alunos) {
            if (aluno.getId().equals(id)) {
                return aluno;
            }
        }
        throw new Exception("Aluno não encontrado!");
    }
}
