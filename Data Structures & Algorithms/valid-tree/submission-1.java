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

    public void union(int u, int v){
        int pu = findParent(u);
        int pv = findParent(v);

        if(size[pu] < size[pv]){
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}

class Solution {
    public boolean validTree(int n, int[][] edges) {
        DisjointSet ds = new DisjointSet(n);

        for(int[] e : edges){
            if(ds.findParent(e[0]) == ds.findParent(e[1])){
                return false;
            }
            ds.union(e[0], e[1]);
        }

        for(int i = 0; i < n -1; i++){
            if(ds.parent[ds.findParent(i)] != ds.parent[ds.findParent(i+1)]) return false;
        }

        return true;
    }
}
