package by.azhulpa.task4.autoservice.service;

public interface OrderManager<T> extends EntityManager<T>{//�������� ���������
	
	void toCancel();
}
