/*
 * ���� �����忡�� ȭ�鿡 ������ ������Ʈ���� ������ ó���ϴٺ��� ������������ �������� ������, ���� �ϰ����̸鼭
 * ü�輺�ִ� ��ü�� ������ ���簡 �ʿ��ϰ�, �� ��ü�� �̸��� ObjectManager�� �ϰڴ�!!
 * */
package com.sds.game;

import java.util.ArrayList;

public class ObjcetManager {
	//���ӿ� �����ϰ� �� ��� ��ü�� ��Ե� �÷���!
	ArrayList<GameObject> objcetList=new ArrayList<GameObject>();
	
	//ȭ�鿡 �����Ű��!!=�÷��� �����ӿ��� �߰�
	public void addObject(GameObject gameObject) {
		objcetList.add(gameObject);

	}
	
	//ȭ�鿡�� �����ϱ�!!=�÷��� �����ӿ����� ����
	public void removeObjcet(GameObject gameObject) {
		objcetList.remove(gameObject);

	}
}
