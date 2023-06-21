package com.alswo.List;

import java.util.Currency;

/*import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;*/

public class LinkedListExample {

	// 연결리스트의 노드 클래스
	static class Node {
		int data;		// 데이터
		Node next;		// 다음 노드를 가리키는 포인터
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	
	// 연결리스트 클래스
	private static class LinkedList {
		Node head;		// 연결리스트의 첫 번째 노드를 가리키는 포인터
		
		// 연결리스트에 데이터를 추가하는 메서드
		void add(int data) {
			Node newNode = new Node(data);		// 새로운 노드 생성
			if(head == null) {
				head = newNode;		// 연결리스트가 비어있을 경우 새로운 노드를 첫 번째 노드로 설정
			} else {
				Node current = head;
				while (current.next != null) {
					current = current.next;
				}
				current.next = newNode;		// 마지막 노드의 다음에 새로운 노드를 추가
			}
		}
		
		// 중간 삽입
		void insert(Node prevNode, int data) {
			if (prevNode == null) {
				System.out.println("이전 노드가 Null입니다.");		// 이전 노드가 없을 경우 예외 처리
				return;
			}
			Node newNode = new Node(data);		// 새로운 노드 생성
			newNode.next = prevNode.next;		
			prevNode.next = newNode;		// 이전 노드의 다음 노드로 새로운 노드를 연결
		}
		
		// 중간 삭제
		void delete(int data) {
			Node prevNode = null;
			Node current = head;
			
			if (current != null && current.data == data) {
				head = current.next;		// 첫 번째 노드를 삭제하는 경우 head를 다음 노드로 변경
				return;
			}
			
			while (current != null && current.data != data) {
				prevNode = current;
				current = current.next;
			}
			
			if (current == null) {
				System.out.println("삭제할 노드를 찾을 수 없다.");	// 삭제할 노드를 찾지 못한 경우 예외 처리
				return;
			}
			
			prevNode.next = current.next;	// 이전 노드의 다음 노드를 삭제할 노드의 다음 노드로 연결
			
		}
		
		// 순차 정렬
		void sequentialSort() {
			if (head == null || head.next == null) {
				// 연결리스트가 비어있거나 단일 노드만 있는 경우 정렬할 필요 X
				return;
			}
			
			Node current = head;	// 현재 노드를 가리키는 포인터
			Node index = null;		// 다음 노드를 가리키는 포인터
			int temp;	// 값 교환을 위한 임시 변수
			
			while (current != null) {	// 현재 노드가 null이 될 때까지 반복
				index = current.next;	// 다음 노드로 이동
				
				while (index != null) {		// 다음 노드가 null일 될 때까지 반복
					if (current.data > index.data) {
						
						// 현재 노드의 데이터가 다음 노드의 데이터보다 크면 값 교환
						temp = current.data;
						current.data = index.data;
						index.data = temp;
					}
					
					index = index.next;		// 다음 노드로 이동
				}
				
				current = current.next;		// 현재 노드를 다음으로 이동
			}
		}
		
		void display() { 
			// 루프를 돌면서 출력하는 메서드 
			// 노드를 방문하여 데이터 출력 후 다음 노드로 이동
			Node current = head;
			while (current != null) {
				System.out.print(current.data + " ");
				current = current.next;
			}
			System.out.println();		// 출력 하면서 줄바꿈 수행
		}
	}
	
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();		// 연결리스트 객체 생성
        
        linkedList.add(5);
        linkedList.add(10);
        linkedList.add(100);
        linkedList.add(110);
        linkedList.add(90);
        linkedList.add(15);
        linkedList.add(3);		// 중간 삭제할 숫자
        linkedList.add(20);
        linkedList.add(30);
        linkedList.add(40);
        
        // 중간 삽입
        Node prevNode = linkedList.head;	// 첫 번째 노드
        
        for (int i = 0; i < 4; i++) {		// 25를 5번째 삽입
        	if (prevNode == null) {
        		System.out.println("삽입할 위치 찾을 수 없는디");
        		return;
        	}
        	prevNode = prevNode.next;		// 중간 삽입 위치 변경
        }
        
        linkedList.insert(prevNode, 25);		// 20 다음 중간 삽입
        linkedList.insert(prevNode.next.next, 35);		// 30 다음 중간 삽입
        
        // 삭제
        linkedList.delete(3);
        
        // 순차 정렬 출력
        linkedList.sequentialSort();

//		파일로 읽는 거 필요 없어서 주석처리        
//        try (BufferedReader br = new BufferedReader(new FileReader("./numbers.txt"))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                int number = Integer.parseInt(line);
//                linkedList.add(number);		// 파일에서 읽은 숫자를 연결리스트에 추가
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        	
        Node current = linkedList.head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
            
            linkedList.display();		// 연결리스트의 모든 노드를 출력
        }
        System.out.println();
        
        // 정렬된 결과 출력
        linkedList.display();
    }
}
