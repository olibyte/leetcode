class Solution:
    def minimumCardPickup(self, cards: List[int]) -> int:
        #walk through cards
        # store card and index at which we saw it
        # if the card is already in the dict we have a pair
        # consecutive cards is is distance from indice of the current card to indice of which we first saw it
        # calculate min consecutive cards it took to find a pair
        # initiate result to handle constraint / impossibility of finding a pair
        card_index_map = {}
        result = math.inf
        for i in range(0,len(cards)):
            card = cards[i]
            if card in card_index_map:
                result = min(i-card_index_map[card]+1,result)
            card_index_map[card] = i
        if result == math.inf:
            return -1
        return result
            