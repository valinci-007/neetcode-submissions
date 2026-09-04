class DisjointSet {
    public int[] size;
    public int[] parent;

    public DisjointSet(int n){
        size = new int[n];
        parent = new int[n];

        for(int i=0; i<n; i++){
            size[i] = 1;
            parent[i] = i;
        }
    }

    public int findParent(int u){
        if(parent[u] == u){
            return u;
        }

        return parent[u] = findParent(parent[u]);
    }

    public boolean union(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);

        if (pu == pv){
            return false;
        }

        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }

        return true;
    }
}

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DisjointSet ds = new DisjointSet(n+1);

        for(int[] e : edges){
            if (!ds.union(e[0], e[1])){
                return e;
            }
        }

        return new int[]{};
    }
}
