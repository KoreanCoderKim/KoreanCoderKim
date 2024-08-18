import java.io.*;
import java.util.*;
public class WalkDOG {
int[] dx = {0,0,-1,1};
int[] dy = {-1,1,0,0};
int n,m;
int walkcount=0;
boolean[][] visited;
public int bfs(int x,int y,int[][] maps) {
Queue<Node> q = new LinkedList<>();
q.offer(new Node(x,y,0));
visited[x][y] = true;

while(!q.isEmpty()) {
Node node = q.poll();
walkcount=node.walk+1;
for (int i=0;i<4;i++) {
int nx = node.x+dx[i];
int ny=node.y+dy[i];

if(nx>=0&&ny>=0&&nx<n&&ny<m) {
if(maps[nx][ny] == 1 && !visited[nx][ny]) {
visited[nx][ny]=true;
maps[nx][ny]=0;
q.offer(new Node(nx,ny,walkcount));
}
}
}
}
return walkcount;
}
public class Node{
int x,y,walk;
public Node(int x,int y,int walk) {
this.x=x;
this.y=y;
this.walk=walk;
}
}
public static void main(String[] args) {
int[][] maps = {{1,0,1,1},{1,1,0,1},{0,1,0,0},{0,1,1,1}};
WalkDOG wd = new WalkDOG();
wd.n=maps.length;
wd.m=maps[0].length;
wd.visited = new boolean[wd.n][wd.m];
int answer = wd.bfs(0,0,maps);
System.out.println("DOG Walks Count is "+answer);
}
}
