package orm.actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Tarefa;

public class AtualizarTarefa {
	public static void main(String[] args) {
		Tarefa tarefa = new Tarefa();
		
		tarefa.setId(1L);
		tarefa.setDescricao("Estudar javarada");
		tarefa.setFinalizado(false);
		tarefa.setDataFinalizacao(null);
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		manager.getTransaction().begin();
		manager.merge(tarefa);
		manager.getTransaction().commit();
		
		System.out.println("Atualização concluida");
		
		manager.close();
	}
}
