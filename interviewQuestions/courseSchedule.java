package interviewQuestions;

import java.util.ArrayList;

public class courseSchedule {
    ArrayList<Integer> graph[];    
    public boolean dfs(int visited[],int oneNode)
    {
        if(visited[oneNode]==1)
            return false;
        
        if(visited[oneNode]==2)
            return true;
        
        visited[oneNode]=1;
        for(int child:graph[oneNode])
            if(!dfs(visited,child))
                return false;
        
        visited[oneNode]=2;
        return true;
        
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++)
                graph[i]=new ArrayList<>();
            
        for(int[] oneNode:prerequisites)    
            graph[oneNode[0]].add(oneNode[1]);
    
        int visited[]=new int[numCourses];
        for(int[] oneNode:prerequisites)
        {
            if(visited[oneNode[0]]==0)
                if(!dfs(visited,oneNode[0]))
                    return false;
        }
        return true;        
    }
}
