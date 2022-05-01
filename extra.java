// Distinct Subsequence
// Choose a subsequnece such that frequency of each distinct element is same.
int solve(int a[], int n){
    Map<Integer, Integer> map = new HashMap<>();
    for(int i=0; i<n; i++){
        map.put(a[i], map.getOrDefault(a[i], 0)+1);
    }

    List<Integer> values = new ArrayList<>(map.values());
    Collections.sort(values);

    if(values.size()==1){
        return map.get(a[0]);
    }

    int idxOfMidValue = values.size()/2;
    int frequency = val.get(idxOfMidValue);

    int count = 0;
    for(int i=0; i<values.size(); i++){
        if(values[i]<frequency){
            continue;
        }
        else{
            count++;
        }
    }

    return count*frequency;
}