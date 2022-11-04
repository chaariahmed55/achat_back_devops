package tn.esprit.rh.achat;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.repositories.FactureRepository;
import tn.esprit.rh.achat.services.FactureServiceImpl;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class FactureServiceTest {

	@Mock
	FactureRepository sr;
	@InjectMocks
	FactureServiceImpl ss;

	@Test
	public void testAddFacture() {
		Facture facture = new Facture();
		Mockito.when(sr.save(ArgumentMatchers.any(Facture.class))).thenReturn(facture);
		Facture Factureadd = ss.addFacture(facture);
		assertThat(Factureadd.getIdFacture()).isSameAs(Factureadd.getIdFacture());
	}

	
	@Test
	public void RetrieveAllFactureTest() {
		List<Facture> facture = new ArrayList();
		facture.add(new Facture());
		when(sr.findAll()).thenReturn(facture);
		List<Facture> expected = ss.retrieveAllFactures();
		assertEquals(expected, facture);
		verify(sr).findAll();
	}

	
	@Test
	public void DeleteFactureIfExistTest() {
		Facture facture = new Facture();
		facture.setIdFacture(1L);
		facture.setArchivee(null);
		facture.setDateCreationFacture(null);
		 System.out.println("testdeletefacture");
		 System.out.println("testdeletefacture");
		 ss.cancelFacture(66L);
		 Mockito.verify(sr, times(0)).delete(facture);
	};
}
