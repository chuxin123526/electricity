package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.believe.electricity.po.DataDictionaryType;
import com.believe.electricity.po.Privilege;
import com.believe.electricity.po.Role;

public class Test
{
	@org.junit.Test
	public void testInverse() throws Exception
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml") ; 
		SessionFactory sessionFactory =(SessionFactory) applicationContext.getBean("sessionFactory") ;
		Session session = sessionFactory.openSession() ; 
		session.beginTransaction() ; 
		DataDictionaryType dataDictionaryType = new DataDictionaryType() ; 
		dataDictionaryType.setId(1);
		session.delete(dataDictionaryType);
		session.getTransaction().commit(); 
	
	}
	
	
	@org.junit.Test
	public void initData() throws Exception
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml") ; 
		SessionFactory sessionFactory =(SessionFactory) applicationContext.getBean("sessionFactory") ;
		Session session = sessionFactory.openSession() ; 
		session.beginTransaction() ; 
		
		//初始化角色
		Role role = new Role() ; 
		role.setName("低级管理员");
		
		Role role2 =new Role() ; 
		role2.setName("中级管理员");
		
		Role role3 = new Role() ; 
		role3.setName("高级管理员");
		
		
		
		//初始化权限
		//系统管理
		Privilege privilege = new Privilege() ; 
		privilege.setName("系统管理");
		privilege.setIsMenu(true);
		privilege.setIsParent(false);
		
		Privilege privilege2 = new Privilege() ; 
		privilege2.setName("用户管理");
		privilege2.setUrl("userAction_list.action");
		privilege2.setIsMenu(false);
		privilege2.setIsParent(false);
		privilege2.setParent(privilege);
		
		Privilege privilege6 = new Privilege() ; 
		privilege6.setName("查询");
		privilege6.setUrl("userAction_query");
		privilege6.setIsMenu(false);
		privilege6.setIsParent(false);
		privilege6.setParent(privilege2);
		
		Privilege privilege7 = new Privilege() ; 
		privilege7.setName("删除");
		privilege7.setUrl("userAction_delete.action");
		privilege7.setIsMenu(false);
		privilege7.setIsParent(false);
		privilege7.setParent(privilege2);
		
		Privilege privilege8 = new Privilege() ; 
		privilege8.setName("添加");
		privilege8.setUrl("userAction_add.action");
		privilege8.setIsMenu(false);
		privilege8.setIsParent(false);
		privilege8.setParent(privilege2);
		
		Privilege privilege9 = new Privilege() ; 
		privilege9.setName("修改");
		privilege9.setUrl("userAction_update.action");
		privilege9.setIsMenu(false);
		privilege9.setIsParent(false);
		privilege9.setParent(privilege2);
		
		
		
		Privilege privilege3 = new Privilege() ; 
		privilege3.setName("角色管理");
		privilege3.setUrl("roleAction_index");
		privilege3.setIsMenu(false);
		privilege3.setIsParent(false);
		privilege3.setParent(privilege);
		
		Privilege privilege10 = new Privilege() ; 
		privilege10.setName("添加");
		privilege10.setUrl("roleAction_add");
		privilege10.setIsMenu(false);
		privilege10.setIsParent(false);
		privilege10.setParent(privilege3);
		
		Privilege privilege11 = new Privilege() ; 
		privilege11.setName("删除");
		privilege11.setUrl("roleAction_delete");
		privilege11.setIsMenu(false);
		privilege11.setIsParent(false);
		privilege11.setParent(privilege3);
		
		Privilege privilege12 = new Privilege() ; 
		privilege12.setName("修改");
		privilege12.setUrl("roleAction_update");
		privilege12.setIsMenu(false);
		privilege12.setIsParent(false);
		privilege12.setParent(privilege3);
		
		
		Privilege privilege4 = new Privilege() ; 
		privilege4.setName("运行监控");
		privilege4.setUrl("baseMessageAction_info");
		privilege4.setIsMenu(false);
		privilege4.setIsParent(false);
		privilege4.setParent(privilege);
		
		Privilege privilege5 = new Privilege() ; 
		privilege5.setName("数据字典维护");
		privilege5.setUrl("dataDictionaryAction_list");
		privilege5.setIsMenu(false);
		privilege5.setIsParent(false);
		privilege5.setParent(privilege);
		
		session.save(privilege) ; 
		session.save(privilege5) ; 
		session.save(privilege4) ; 
		session.save(privilege3) ; 
		session.save(privilege2) ; 
		session.save(privilege9) ;
		session.save(privilege8) ; 
		session.save(privilege7) ; 
		session.save(privilege6) ; 
		session.save(privilege12) ; 
		session.save(privilege11) ; 
		session.save(privilege10) ;
		
		
		
		
		
		session.getTransaction().commit(); 
	}
}
