import json

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

# Formulas
add2_intervals = [0, 2, 4, 7]      # Root + 2nd + 3rd + 5th
add9_intervals = [0, 4, 7, 14]     # Root + 3rd + 5th + 9th (octave higher)
add11_intervals = [0, 4, 7, 17]    # Root + 3rd + 5th + 11th

def create_chord_positions(intervals, root_semitone):
    frets = []
    for i, interval in enumerate(intervals):
        semitone = (root_semitone + interval) % 24
        finger = (i % 5) + 1
        frets.append({"s": finger, "f": semitone})
    
    return [
        {"instrument": "PIANO", "frets": frets},
        {"instrument": "GUITAR", "frets": [{"s": 1, "f": 0}, {"s": 2, "f": 0}, {"s": 3, "f": 0}, {"s": 4, "f": 0}, {"s": 5, "f": 0}, {"s": 6, "f": 0}]},
        {"instrument": "UKULELE", "frets": [{"s": 1, "f": 0}, {"s": 2, "f": 0}, {"s": 3, "f": 0}, {"s": 4, "f": 0}]}
    ]

for root_name, root_semitone in roots.items():
    display_root = root_name.replace("S", "#").replace("B", "b")
    
    # ADD2 (add2)
    chords[f"{root_name}ADD2"] = {
        "name": f"{display_root}add2",
        "positions": create_chord_positions(add2_intervals, root_semitone)
    }
    
    # ADD9 (add9) - was just ADD
    chords[f"{root_name}ADD"] = {
        "name": f"{display_root}add9",
        "positions": create_chord_positions(add9_intervals, root_semitone)
    }
    
    # ADD11 (add11)
    chords[f"{root_name}ADD11"] = {
        "name": f"{display_root}add11",
        "positions": create_chord_positions(add11_intervals, root_semitone)
    }

# Write back
with open('app/src/main/assets/chords.json', 'w') as f:
    json.dump({"chords": chords}, f, indent=2)

print(f"Added ADD2, ADD9, ADD11 for {len(roots)} roots = {len(roots)*3} chords total")
