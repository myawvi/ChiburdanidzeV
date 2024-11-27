import tkinter as tk
import requests
import json

def fetch_repository_data():
    repo_name = entry.get()  
    url = f"https://api.github.com/users/{repo_name}"  
    response = requests.get(url)

    if response.status_code == 200:
        data = response.json()
        result = {
            'company': None,
            'created at': data.get('created_at'),
            'email': None,
            'id': data.get('id'),
            'name': data.get('name'),
            'url': f"https://api.github.com/users/{repo_name}"
        }
        
        with open('repo_data.json', 'w') as json_file:
            json.dump(result, json_file, indent=4)
        
        
        result_text.set(json.dumps(result, indent=4))
    else:
        result_text.set(f"Error: {response.status_code} - {response.text}")


root = tk.Tk()
root.title("GitHub Repository Fetcher")


label = tk.Label(root, text="введите имя репозитория (например, kubernetes):")
label.pack()

entry = tk.Entry(root)
entry.pack()

fetch_button = tk.Button(root, text="получить данные", command=fetch_repository_data)
fetch_button.pack()

result_text = tk.StringVar()
result_label = tk.Label(root, textvariable=result_text, justify="left")
result_label.pack()


root.mainloop()
