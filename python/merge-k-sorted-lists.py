class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __str__(self):
        return str(self.val) + " -> " + str(self.next)

class Solution:
    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        if not lists: return None

        def merge(list1, list2):
            if not list1: return list2
            if not list2: return list1

            pivot = ListNode()
            tail = pivot
            while list1 and list2:
                if list1.val < list2.val:
                    tail.next = list1
                    tail = tail.next
                    list1 = list1.next
                else:
                    tail.next = list2
                    tail = tail.next
                    list2 = list2.next
            if list1 is None:
                tail.next = list2
            elif list2 is None:
                tail.next = list1
            return pivot.next

        while len(lists) > 1:
            for i in range(0, len(lists), 2):
                list1 = lists.pop()
                list2 = lists.pop()
                merged = merge(list1, list2)
                print(merged)
                lists.append(merged)

        return lists

    def mergeKLists2(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:
        pq = []
        for ll in lists:
            while ll:
                val = ll.val
                pq.append(val)
                ll = ll.next
        heapq.heapify(pq)
        dummy = ListNode()
        tail = dummy
        while pq:
            val = heapq.heappop(pq)
            tail.next = ListNode(val)
            tail = tail.next
        return dummy.next


def build_list(data):
    pivot = ListNode()
    tail = pivot
    for i in data:
        node = ListNode(i)
        tail.next = node
        tail = tail.next
    return pivot.next

a = [[1,4,5],[1,3,4],[2,6]]

b = [build_list(l) for l in a]
print(b[2])

s = Solution()
print(s.mergeKLists(b)[0])

print(1 & 2147483647)
