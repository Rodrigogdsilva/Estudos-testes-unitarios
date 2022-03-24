package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

class BonusServiceTest {

	@Test
	void bonusZeroParaFuncionariosComSalarioMuitoAlto() {
		BonusService service = new BonusService();

		assertThrows(IllegalArgumentException.class,
				() -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));

	}

	@Test
	void bonusDezPorcentoParaFuncionariosComSalarioDentroDoLimite() {
		BonusService bonus = new BonusService();
		BigDecimal bonusSalario = bonus
				.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonusSalario);

	}

	@Test
	void bonusDezPorcentoParaFuncionariosComSalarioDentroNoLimite() {
		BonusService bonus = new BonusService();
		BigDecimal bonusSalario = bonus
				.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonusSalario);

	}

}
