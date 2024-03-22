package br.com.exercicios.modulo1semana8.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Data
public class CursoModel {

    private static Integer proximoId = 1;

    @Getter private static List<CursoModel> cursos = new ArrayList<>();

    @Setter(AccessLevel.NONE) private Integer id;
    private String nome;
    private String descricao;
    private Integer cargaHoraria;
    private List<AlunoModel> alunosMatriculados = new ArrayList<>();

    static Integer getProximoId() {
        return proximoId++;
    }
    public static CursoModel inserir(CursoModel curso) {
        curso.id = getProximoId();
        cursos.add(curso);
        return curso;
    }
    public static CursoModel buscarPorId(Integer id) throws Exception {
        for (CursoModel curso : cursos) {
            if (curso.getId().equals(id)) {
                return curso;
            }
        }
        throw new Exception("Curso não encontrado!");
    }

    public static void matricular(CursoModel curso, AlunoModel aluno) {
        curso.alunosMatriculados.add(aluno);
    }


}
