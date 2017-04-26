public class O1时间插入删除和随机 {
    HashMap<String,List<String>> m_map;
    List<String> m_list;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        m_map = new HashMap();
        m_list = new ArrayList<String>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        m_list.add(val+"");
        if(m_map.containsKey(val+"")){
            List lst = m_map.get(val+"");
            lst.add(m_list.size() - 1 + "");
            m_map.put(val+"", lst);
            return false;
        }
        else{
            List lst = new ArrayList<String>();
            lst.add(m_list.size() - 1 + "");
            m_map.put(val+"", lst);
            return true;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(m_map.containsKey(val + "")){
            if(m_map.get(val + "").size() == 1){
                m_list.remove(Integer.parseInt(m_map.get(val + "").get(0)));
                m_map.remove(val+"");
            }
            else{
                List lst = m_map.get(val + "");
                int index = Integer.parseInt(lst.get(0).toString());
                lst.remove(0);
                m_list.remove(index);
                m_map.put(val+"", lst);
            }
            return true;
        }
        else{
            return false;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        if(m_list.size() == 0){
            return 0;
        }
        int rand = (int)(Math.random() * m_list.size());
        return Integer.parseInt(m_list.get(rand));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */