class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        """
        Time complexity: O(n log n)
        Space complexity: O(n), because we used two additional arrays
        """
        # counting elements O(n)
        # Sort elements O(n log n) using the frequency number
        # Take the fisrt k, O(k)
        # Overall complexity is O(n log n)
        counter = Counter(nums)
        data = []
        for n, val in counter.items():
            data.append((val, n))
        sorted(data)
        result = []
        for i in range(k):
            result.append(data.pop()[1])
        return result

    def topKFrequent2(self, nums: List[int], k: int) -> List[int]:
        """
        Time complexity: O(n log k)
        Space complexity: O(n  + k)
        """
        # counting elements O(n)
        # insert all elements into a heap
        # if the size of the heap is greater than k, pop smallest element O(n log k)
        # Take the fisrt k, O(k)
        # Overall complexity is O(n log k)

        counter = Counter(nums)
        data = []
        for n, val in counter.items():
            heapq.heappush(data, (val, n))
            if len(data) > k:
                heapq.heappop(data)
        result = []
        for i in range(k):
            result.append(heapq.heappop(data)[1])
        return result

    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        counter = Counter(nums)
        freq = [[] for i in range(len(nums) + 1)]

        for n, val in count.items():
            freq[val].append(n)

        res = []
        for i in range(len(freq) - 1, 0, -1):
            for num in freq[i]:
                res.append(num)
                if len(res) == k:
                    return res
