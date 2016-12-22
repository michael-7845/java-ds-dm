package ds.graph;

import java.util.*;

/**
 * ʹ���ڽӾ���ʵ��ͼ<p>
 * ������ȱ����������ȱ���<p>
 * �����·��:<p>
 *      1. Dijkstra �㷨 <p>
 *      2. Ford �㷨 <p>
 *      3. ͨ���͵ľ�������㷨<p>
 * Created by Henvealf on 16-5-22.
 */
public class Graph<T> {
    private int[][] racs;       //�ڽӾ���
    private T[] verticeInfo;   //��������Я������Ϣ.

    private int verticeNum;             //�ڵ����Ŀ,
    private int[] visitedCount;         //��¼����
    private int[] currDist;             //���·���㷨��������¼ÿ���ڵ�ĵ�ǰ·������.

    public Graph(int[][] racs, T[] verticeInfo){
        if(racs.length != racs[0].length){
            throw new IllegalArgumentException("racs is not a adjacency matrix!");
        }
        if(racs.length != verticeInfo.length ){
            throw new IllegalArgumentException ("Argument of 2 verticeInfo's length is error!");
        }
        this.racs = racs;
        this.verticeInfo = verticeInfo;
        verticeNum = racs.length;
        visitedCount = new int[verticeNum];
    }

    /**
     * ��ȱ����ĵݹ�
     * @param begin  �ӵڼ����ڵ㿪ʼ����
     */
    public void DFS(int begin, Queue<T> edges){
        visitedCount[begin] = 1;                         //���beginΪ�ѷ���
        edges.offer(verticeInfo[begin]);                 //�����¼����
        for(int a = 0; a < verticeNum; a++){             //�������ڵĵ�
            if((racs[begin][a] != Integer.MAX_VALUE)&& visitedCount[a] == 0){   //���ڵĵ�δ�����ʹ�
                DFS(a,edges);
            }
        }
    }

    /**
     * ��ʼ������ȱ���
     * @return  ���ر����б���֮���˳��Ķ���
     */
    public Queue<T> depthFirstSearch(){
        initVisitedCount();         //����¼���ʴ���������ʼ��Ϊ0
        Queue<T> edges = new LinkedList<T>();    //���ڴ洢�������ĵ�,�������
        int begin = -1;
        while((begin = findNotVisited()) != -1){        //������-1˵������δ���ʹ��ĵ�
            DFS(begin,edges);
        }
        return edges;
    }

    /**
     * ������ȱ���
     * @return  ���ر����б���֮���˳��Ķ���
     */
    public Queue<T> breadthFirstSearch(){
        initVisitedCount();                          //����¼���ʴ���������ʼ��Ϊ0
        Queue<Integer> tallyQueue = new LinkedList<Integer>();             //��ʼ������
        Queue<T> edges = new LinkedList<T>();    //���ڴ洢�������ĵ�,�������
        int nowVertice = -1;                         //��ǰ���ڵĵ�
        while((nowVertice = findNotVisited()) != -1){   //Ѱ�һ�δ���ù��ʵĵ�
            visitedCount[nowVertice] = 1;             //���÷��ʱ��
            edges.offer(verticeInfo[nowVertice]);
            tallyQueue.offer(nowVertice);               //����ǰ��������һ����������¼������
            while(!tallyQueue.isEmpty()){                           //ֻҪ���в�Ϊ��
                nowVertice = tallyQueue.poll();                     //ȡ�����׵Ľڵ�
                for(int a = 0; a < verticeNum; a++){     //�������к�nowVertice���ڵĽڵ�
                    if((racs[nowVertice][a] != Integer.MAX_VALUE) && visitedCount[a] == 0) {                      //û�з��ʹ�
                        visitedCount[a] = 1;                        //��Ϊ��ǹ�
                        tallyQueue.offer(a);                        //�������,��������ȡ��.������
                        edges.offer(verticeInfo[a]);                      //��¼
                    }
                }
            }
        }
        return edges;
    }

    /**
     * Ѱ��û�б����ʹ��Ķ���.
     * @return > 0 ��Ϊ��δ�����ʹ��Ķ���.   -1 ˵�����еĽڵ㶼�����ʹ���.
     */
    private int findNotVisited(){
        for(int i = 0; i < verticeNum; i ++){
            if(visitedCount[i] == 0){
                return i;
            }
        }
        return -1;
    }

    /**
     * ����¼���ʵ������ʼ��Ϊ0
     */
    private void initVisitedCount(){
        for(int i = 0; i < visitedCount.length; i ++){
            visitedCount[i] = 0;
        }
    }
}