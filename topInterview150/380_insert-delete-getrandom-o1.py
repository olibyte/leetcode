import random

class RandomizedSet:
    def __init__(self):
        self.hash_map = {}  # Dictionary to store the mapping between elements and their indices
        self.elements = []  # List to store the elements
    
    def insert(self, val: int) -> bool:
        if val in self.hash_map:
            return False  # If val is already present, return False
        else:
            self.elements.append(val)  # Append val to list of elements
            self.hash_map[val] = len(self.elements) - 1  # Update the mapping
            return True
    
    def remove(self, val: int) -> bool:
        if val in self.hash_map:
            idx = self.hash_map[val]  # Get the index of val in the list
            last_element = self.elements[-1]  # Get the last element in the list
            
            # Swap the element to be removed with the last element in the list
            self.elements[idx], self.elements[-1] = self.elements[-1], self.elements[idx]
            self.hash_map[last_element] = idx  # Update the mapping for the last element
            
            self.elements.pop()  # Remove the last element from the list
            del self.hash_map[val]  # Remove val from the mapping
            
            return True
        else:
            return False  # If val is not present, return False
    
    def getRandom(self) -> int:
        return random.choice(self.elements)  # Return a random element from the list


# Your RandomizedSet object will be instantiated and called as such:
# obj = RandomizedSet()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()