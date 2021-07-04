package com.company.produtos.controller;

import com.company.produtos.dao.ProdutoDao;
import com.company.produtos.dto.ProdutoDto;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @GetMapping("")
    public ResponseEntity<?> getProduto(){

        List<ProdutoDto> resp = new ArrayList<>();

        ProdutoDao.readAll().forEach(x->resp.add(ProdutoDto.convertDto(x)));

        return new ResponseEntity<>(resp, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduto(@PathVariable String id){

        List<ProdutoDto> resp = new ArrayList<>();

        resp.add(ProdutoDto.convertDto(ProdutoDao.readAll().stream().filter(x->x.getCodigo().equals(id)).findFirst().get()));

        return new ResponseEntity<>(resp, HttpStatus.OK);

    }

    @PostMapping("")
    public ResponseEntity<?> postGravar(@RequestBody ProdutoDto p){

        List<ProdutoDto> resp = new ArrayList<>();

        resp.add(ProdutoDto.convertDto(ProdutoDao.save(p)));

        return new ResponseEntity<>(resp, HttpStatus.CREATED);

    }

    @PutMapping("")
    public ResponseEntity<?> putUpdate(@RequestBody ProdutoDto p){

        List<ProdutoDto> resp = new ArrayList<>();

        resp.add(ProdutoDto.convertDto(ProdutoDao.update(p)));

        return new ResponseEntity<>(resp, HttpStatus.ACCEPTED);

    }

    @DeleteMapping("")
    public ResponseEntity<?> delDelete(@RequestBody ObjectNode json){

        String codigo = json.get("codigo").textValue();

        ProdutoDao.delete(codigo);

        return new ResponseEntity<>("Produto apagado com sucesso!", HttpStatus.ACCEPTED);

    }


}
