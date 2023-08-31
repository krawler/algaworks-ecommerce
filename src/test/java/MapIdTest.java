import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.algaworks.ecommerce.jpa.EntityManagerAbstract;
import com.algaworks.ecommerce.model.NotaFiscal;
import com.algaworks.ecommerce.model.Pedido;

public class MapIdTest extends EntityManagerAbstract {
	
		
	@Test
	public void inserirPagamento() {
	
		Pedido pedido = manager.find(Pedido.class, 1);
		
		NotaFiscal nota = new NotaFiscal();
		nota.setPedido(pedido);
		nota.setDataEmissao(new Date());
		nota.setXml("<XML />");
		
		manager.getTransaction().begin();
		manager.persist(nota);
		manager.getTransaction().commit();
		
		manager.clear();
		
		NotaFiscal NotaFiscalVerify = manager.find(NotaFiscal.class, nota.getId());
		Assert.assertNotNull(NotaFiscalVerify);
		Assert.assertEquals(pedido.getId(), NotaFiscalVerify.getPedido().getId());
	}

}
