package service;

import model.Conta;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.is;

public class ContaServiceTesteExceptions {

    @Test(expected = Exception.class)
    public void deveLancarExceptionQuandoValorDoSaqueForNegativo_2() throws Exception{
        // Given
        ContaService contaService = new ContaService();
        Conta c1 = contaService.cadastrar("Marcela");

        // When
        contaService.sacar(c1,-10.0);
        // Then
        // deve lançar exception


    }

    @Test
    public void deveLancarExceptionQuandoValorDoSaqueForNegativo_3() {
        // Given
        ContaService contaService = new ContaService();
        Conta c1 = contaService.cadastrar("Marcela");

        try {
            contaService.sacar(c1,-10.0);
            Assert.fail();
        } catch (Exception e) {
            // capturar exception
            Assert.assertThat(e.getMessage(), is("O valor do saque não pode ser negativo"));
        }
        // Then
        // deve lançar exception


    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void deveLancarExceptionQuandoValorDoSaqueForNegativo() throws Exception{
        // Given
        ContaService contaService = new ContaService();
        Conta c1 = contaService.cadastrar("Marcela");

        // Expect
        expectedException.expect(Exception.class);
        expectedException.expectMessage("O valor do saque não pode ser negativo");

        // When
        contaService.sacar(c1,-10.0);
        // Then
        // deve lançar exception


    }


}
