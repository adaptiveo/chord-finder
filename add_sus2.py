import json
import re

# Read existing chords
with open('app/src/main/assets/chords.json', 'r') as f:
    data = json.load(f)

chords = data['chords']

# Root notes with semitones
roots = {
    "C": 0, "CS": 1, "DB": 1, "D": 2, "DS": 3, "EB": 3,
    "E": 4, "F": 5, "FS": 6, "GB": 6, "G": 7, "GS": 8,
    "AB": 8, "A": 9, "AS": 10, "BB": 10, "B": 11
}

# SUS2 formula: root + major 2nd (2 semitones) + perfect 5th (7 semitones)
sus2_intervals = [0, 2, 7]

for root_name, root_semitone in roots.items():
    json_key = f"{root_name}SUS2"
    display_name = root_name.replace("S", "#").replace("B", "b") + "sus2"
    
    # Calculate fret positions
    frets = []
    for i, interval in enumerate(sus2_intervals):
        semitone = (root_semitone + interval) % 24
        finger = (i % 5) + 1
        frets.append({"s": finger, "f": semitone})
    
    positions = [
        {"instrument": "PIANO", "frets": frets},
        {"instrument": "GUITAR", "frets": [{"s": 1, "f": 0}, {"s": 2, "f": 0}, {"s": 3, "f": 0}, {"s": 4, "f": 0}, {"s": 5, "f": 0}, {"s": 6, "f": 0}]},
        {"instrument": "UKULELE", "frets": [{"s": 1, "f": 0}, {"s": 2, "f": 0}, {"s": 3, "f": 0}, {"s": 4, "f": 0}]}
    ]
    
    chords[json_key] = {
        "name": display_name,
        "positions": positions
    }

# Write back
with open('app/src/main/assets/chords.json', 'w') as f:
    json.dump({"chords": chords}, f, indent=2)

print(f"Added {len(roots)} SUS2 chords")
