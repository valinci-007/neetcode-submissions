class Solution {
    private void dfs(String airport, Map<String, PriorityQueue<String>> graph, List<String> itenerary){
        PriorityQueue<String> destinations = graph.get(airport);
        while(destinations != null && !destinations.isEmpty()) {
            String newAirport = destinations.poll();
            dfs(newAirport, graph, itenerary);
        }
        itenerary.addFirst(airport);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> ticket : tickets){
            String from = ticket.get(0);
            String to = ticket.get(1);

            if(!graph.containsKey(from)){
                graph.put(from, new PriorityQueue<>());
            }
            graph.get(from).offer(to);
        }

        List<String> itenerary = new ArrayList<>();
        dfs("JFK", graph, itenerary);
        return itenerary;
    }
}
