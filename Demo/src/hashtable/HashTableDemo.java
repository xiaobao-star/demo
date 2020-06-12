package hashtable;

/**
 * 哈希表简单实现
 */
public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.add(new Emp(1,"张三"));
        hashTable.add(new Emp(2,"李四"));
        hashTable.add(new Emp(11,"王五"));
        hashTable.add(new Emp(21,"赵六"));

        hashTable.list();
        hashTable.delete(1);
        System.out.println("删除以后---------------------------------------------------");
        hashTable.list();
    }
}

class HashTable{
    public ArrayListEmp[] arrayListEmps;
    public int size;

    public HashTable(int size){
        this.size = size;
        this.arrayListEmps = new ArrayListEmp[size];
        for (int i = 0; i < arrayListEmps.length; i++) {
            arrayListEmps[i] = new ArrayListEmp();
        }
    }

    public void add(Emp emp){
        arrayListEmps[hash(emp.id)].add(emp);
    }

    public void list(){
        for (int i = 0; i < size; i++) {
            arrayListEmps[i].list(i);
        }
    }

    public Emp selectById(int id){
        return arrayListEmps[hash(id)].selectById(id);
    }

    public void delete(int id){
        arrayListEmps[hash(id)].delete(id);
    }

    public int hash(int id){
        return id % size;
    }
}

class ArrayListEmp{
    public Emp head;

    //增加
    public void add(Emp emp){
        if (head == null){
            head = emp;
            return;
        }


        Emp curEmp = head;
        while (true){
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = emp;
    }
    //遍历显示链表信息
    public void list(int no){
        if (head == null){
            System.out.println("链表为空");
            return ;
        }
        Emp curEmp = head;
        while (true){
            System.out.printf("==>第%s条链表的雇员的id是%d , 雇员的姓名是%s==>\t", no+1, curEmp.id, curEmp.name);
            if (curEmp.next == null){
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    //根据id查找对应的雇员
    public Emp selectById(int id){
        Emp curEmp = head;
        while (true){
            if (curEmp.id == id){
                break;
            }
            if (curEmp.next == null){
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.printf("雇员的信息是:%s,名字是 %s \n",curEmp.id, curEmp.name);
        return curEmp;
    }

    //根据id删除雇员
    public void delete(int id){
        Emp curEmp = head;

        if (head == null){
            return ;
        }

        if (head.id == id){
            head = curEmp.next;
            return;
        }
        while (true){
            if (curEmp.next.id == id){
                break;
            }
            curEmp = curEmp.next;
        }
        curEmp.next = curEmp.next.next;
    }
}

class Emp{
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
