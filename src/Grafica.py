import pandas as pd
import matplotlib.pyplot as plt
import seaborn as sns

# Leer el archivo CSV
df = pd.read_csv('execution_times.csv', header=None, names=['n', 'listType', 'functionName', 'duration'])

# Obtener los tipos de listas únicos
list_types = df['listType'].unique()

# Configurar la paleta de colores
palette = sns.color_palette("tab20")

# Función para verificar si una serie es constante
def is_constant(series):
    return series.nunique() == 1

# Graficar los datos
for list_type in list_types:
    plt.figure(figsize=(12, 8))
    data = df[df['listType'] == list_type]
    functions = data['functionName'].unique()
    constant_offset = 0
    
    for i, function in enumerate(functions):
        function_data = data[data['functionName'] == function]
        if function == 'pushFront':
            function_data['duration'] += 35  # Ajusta este valor según sea necesario
        
        if is_constant(function_data['duration']):
            constant_offset += 7
            function_data['duration'] += constant_offset
        
        sns.lineplot(x='n', y='duration', data=function_data, marker='o', color=palette[i], label=function, linewidth=1.5, ci=None)
    
    plt.title(f'Tiempos de Ejecución para {list_type}', fontsize=16, fontweight='bold')
    plt.xlabel('n', fontsize=16)
    plt.ylabel('Duración (ms)', fontsize=16)
    plt.legend(title='Función', fontsize=14, title_fontsize=16)
    plt.xticks(fontsize=14)
    plt.yticks(fontsize=14)
    plt.grid(True)
    plt.tight_layout()
    plt.show()