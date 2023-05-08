def isAnagram(self, s: str, t: str) -> bool:

    store1 = []
    store2 = []

    for x in s:
        store1[ord(x) - ord('a')] += 1

    for x in t:
        store2[ord(x) - ord('a')] += 1

    return store1 == store2
         

    