package com.alswo.List;

import java.util.Currency;

/*import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;*/

public class LinkedListExample {

	// ���Ḯ��Ʈ�� ��� Ŭ����
	static class Node {
		int data;		// ������
		Node next;		// ���� ��带 ����Ű�� ������
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	// ���Ḯ��Ʈ Ŭ����
	private static class LinkedList {
		Node head;		// ���Ḯ��Ʈ�� ù ��° ��带 ����Ű�� ������
		
		// ���Ḯ��Ʈ�� �����͸� �߰��ϴ� �޼���
		void add(int data) {
			Node newNode = new Node(data);		// ���ο� ��� ����
			if(head == null) {
				head = newNode;		// ���Ḯ��Ʈ�� ������� ��� ���ο� ��带 ù ��° ���� ����
			} else {
				Node current = head;
				while (current.next != null) {
					current = current.next;
				}
				current.next = newNode;		// ������ ����� ������ ���ο� ��带 �߰�
			}
		}
		
		// �߰� ����
		void insert(Node prevNode, int data) {
			if (prevNode == null) {
				System.out.println("���� ��尡 Null�Դϴ�.");		// ���� ��尡 ���� ��� ���� ó��
				return;
			}
			Node newNode = new Node(data);		// ���ο� ��� ����
			newNode.next = prevNode.next;		
			prevNode.next = newNode;		// ���� ����� ���� ���� ���ο� ��带 ����
		}
		
		// �߰� ����
		void delete(int data) {
			Node prevNode = null;
			Node current = head;
			
			if (current != null && current.data == data) {
				head = current.next;		// ù ��° ��带 �����ϴ� ��� head�� ���� ���� ����
				return;
			}
			
			while (current != null && current.data != data) {
				prevNode = current;
				current = current.next;
			}
			
			if (current == null) {
				System.out.println("������ ��带 ã�� �� ����.");	// ������ ��带 ã�� ���� ��� ���� ó��
				return;
			}
			
			prevNode.next = current.next;	// ���� ����� ���� ��带 ������ ����� ���� ���� ����
			
		}
		
		// ���� ����
		void sequentialSort() {
			if (head == null || head.next == null) {
				// ���Ḯ��Ʈ�� ����ְų� ���� ��常 �ִ� ��� ������ �ʿ� X
				return;
			}
			
			Node current = head;	// ���� ��带 ����Ű�� ������
			Node index = null;		// ���� ��带 ����Ű�� ������
			int temp;	// �� ��ȯ�� ���� �ӽ� ����
			
			while (current != null) {	// ���� ��尡 null�� �� ������ �ݺ�
				index = current.next;	// ���� ���� �̵�
				
				while (index != null) {		// ���� ��尡 null�� �� ������ �ݺ�
					if (current.data > index.data) {
						
						// ���� ����� �����Ͱ� ���� ����� �����ͺ��� ũ�� �� ��ȯ
						temp = current.data;
						current.data = index.data;
						index.data = temp;
					}
					
					index = index.next;		// ���� ���� �̵�
				}
				
				current = current.next;		// ���� ��带 �������� �̵�
			}
		}
		
		void display() { 
			// ������ ���鼭 ����ϴ� �޼��� 
			// ��带 �湮�Ͽ� ������ ��� �� ���� ���� �̵�
			Node current = head;
			while (current != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.println();		// ��� �ϸ鼭 �ٹٲ� ����
		}
	}
	
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();		// ���Ḯ��Ʈ ��ü ����
        
        linkedList.add(5);
        linkedList.add(10);
        linkedList.add(100);
        linkedList.add(110);
        linkedList.add(90);
        linkedList.add(15);
        linkedList.add(3);		// �߰� ������ ����
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        
        // �߰� ����
        Node prevNode = linkedList.head;	// ù ��° ���
        
        for (int i = 0; i < 4; i++) {		// 25�� 5��° ����
        	if (prevNode == null) {
        		System.out.println("������ ��ġ ã�� �� ���µ�");
        		return;
        	}
        	prevNode = prevNode.next;		// �߰� ���� ��ġ ����
        }
        
        linkedList.insert(prevNode, 25);		// 20 ���� �߰� ����
        linkedList.insert(prevNode.next.next, 35);		// 30 ���� �߰� ����
        
        // ����
        linkedList.delete(3);
        
        // ���� ���� ���
        linkedList.sequentialSort();

//		���Ϸ� �д� �� �ʿ� ��� �ּ�ó��        
//        try (BufferedReader br = new BufferedReader(new FileReader("./numbers.txt"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                int number = Integer.parseInt(line);
//                linkedList.add(number);		// ���Ͽ��� ���� ���ڸ� ���Ḯ��Ʈ�� �߰�
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        	
        Node current = linkedList.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
            
            linkedList.display();		// ���Ḯ��Ʈ�� ��� ��带 ���
        }
        System.out.println();
        
        // ���ĵ� ��� ���
        linkedList.display();
    }
}
