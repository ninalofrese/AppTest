package com.example.apptest;

import com.example.apptest.repository.CalculoRepository;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ImcUnitTest {

    @Test
    public void repository_calculo() {
        CalculoRepository calculoRepository = new CalculoRepository();
        Float resultado = calculoRepository.calcularIMC(80F, 2F).blockingFirst();

        assertEquals((Float) 20F, resultado);
    }


}