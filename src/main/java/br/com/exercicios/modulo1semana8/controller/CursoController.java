package br.com.exercicios.modulo1semana8.controller;

import br.com.exercicios.modulo1semana8.model.AlunoModel;
import br.com.exercicios.modulo1semana8.model.CursoModel;
import br.com.exercicios.modulo1semana8.service.CursoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }
    @GetMapping
    public List<CursoModel> get() {
        return cursoService.buscarTodos();
    }
    @PostMapping
    public CursoModel post(@RequestBody CursoModel curso) throws Exception {
        return cursoService.salvar(curso);
    }
    @PutMapping("{id}/add-aluno")
    public CursoModel put(@PathVariable Integer id, @RequestBody AlunoModel aluno) throws Exception {
        return cursoService.matricular(id, aluno.getId());
    }

}
