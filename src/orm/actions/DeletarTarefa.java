package orm.actions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import orm.modelo.Tarefa;

public class DeletarTarefa {
	public static void main(String[] args) {
		Tarefa tarefa = new Tarefa();
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tarefas");
		EntityManager manager = factory.createEntityManager();
		
		tarefa.setId(1L);
		
		tarefa = manager.find(Tarefa.class, tarefa.getId());
		
		manager.getTransaction().begin();
		manager.remove(tarefa);
		manager.getTransaction().commit();
		
		System.out.println("Tarefa excluida!");
		
		manager.close();
		
	}
}
