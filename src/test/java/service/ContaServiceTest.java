package service;

import model.Conta;
import org.hamcrest.CoreMatchers;
import org.junit.*;

import static org.hamcrest.MatcherAssert.assertThat;


public class ContaServiceTest {

    ContaService contaService;


    @Before
    public void setup() {
        System.out.println("Before");
        ContaService conta = new ContaService();
    }

    @After
    public void tearDown() {
        System.out.println("After");

    }

    @BeforeClass
    public static void setup2() {

    }

    @AfterClass
    public static void tearDown2() {

    }

    @Test
    public void deveSerPossivelCriarUmaConta() {
        // Given

        // When
        Conta conta = ContaService.cadastrar("Kassia");
        // Then
        Assert.assertEquals(Integer.valueOf(1), conta.getAgencia());
        Assert.assertEquals(Integer.valueOf(1), conta.getNumero());
    }

    @Test
    public void novasContasDevemIniciarComSaldoZero() {
        //Given

        // When
        Conta conta = ContaService.cadastrar("Kassia");
        //Then
        Assert.assertTrue(10 == conta.getSaldo());
    }

    @Ignore
    @Test
    public void assertsPossiveis() {
        Assert.assertTrue(true);
        Assert.assertFalse(true);
        // numeros inteiros
        Assert.assertEquals(1,1);
        // numeros ponto flutuante
        Assert.assertEquals(0.5,0.5, 0.1);//true
        Assert.assertEquals(0.5,0.5, 0.01);//false
        // dizimas periodicas infinitas
        Assert.assertEquals(3.14159999,Math.PI,0.001);//true

    }

    /**
     *
    Assert.assertTrue(true);
    Assert.assertFalse(false);
    Assert.assertEquals(1, 1);
    Assert.assertNotEquals(2 , 10);
    Assert equals comparando duas contas
    Assert.assertSame
    */

    @Test
    public void podeSacarSeSaldoMaiorQueValor() throws Exception {
        // Given
        ContaService contaService = new ContaService();
        Conta conta = ContaService.cadastrar("Igor");
        contaService.depositar(conta,50.0);
        // When
        contaService.sacar(conta,40.0);
        // Then
        Assert.assertTrue(conta.getSaldo()== 10.0);

    }

    @Test
    public void naoPodeSacarValorMaiorQueSaldo() throws Exception {
        // Given
        ContaService contaService = new ContaService();
        Conta conta = ContaService.cadastrar("Igor");
        contaService.depositar(conta,50.0);
        // When
        contaService.sacar(conta,100.0);
        // Then
        Assert.assertFalse(conta.getSaldo() == -50.0);
    }

    @Test
    public void metodoSacarFuncionaCorretamente() throws Exception{
        // Given
        ContaService contaService = new ContaService();
        Conta conta = ContaService.cadastrar("Igor");
        contaService.depositar(conta,50.0);
        // When
        contaService.sacar(conta,40.0);
        // Then
        Assert.assertEquals(10, conta.getSaldo(), 0.01);
    }

    @Test
    public void metodoDepositarFuncionaCorretamente() {
        // Given
        ContaService contaService = new ContaService();
        Conta conta = ContaService.cadastrar("Igor");
        // When
        contaService.depositar(conta,50.0);
        // Then
        Assert.assertNotEquals(10, conta.getSaldo(), 0.01);
    }

    @Test
    public void mesmaContaQuandoMesmoNumeroEMesmaAgencia() {
        // Given
        ContaService contaService = new ContaService();
        //When
        Conta conta1 = ContaService.cadastrar("Igor");
        Conta conta2 = conta1;
        // Then
        Assert.assertEquals(conta1,conta2);
    }

    @Test
    public void mesmaContaQuandoDadosIguais() {
        // Given
        ContaService contaService = new ContaService();
        // When
        Conta conta1 = ContaService.cadastrar("Igor");
        Conta conta2 = conta1;
        // Then
        Assert.assertSame(conta1,conta2);
    }

    @Test
    // não existe mais no JUnit5 assertThat
    public void assertThatTeste() {
        // verifique que...
        Conta contaMaria = contaService.cadastrar("Maria");
        assertThat(contaMaria.getSaldo(), CoreMatchers.is(0.0));
    }








}
