<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
  <title>Sistema de Ventas - Restaurante</title>
  <link rel="stylesheet" href="EstiloSistemaVentas.css" />

  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      background-color: #f4f4f4;
    }

    header {
      background-color: #c0392b;
      color: white;
      padding: 20px;
      text-align: center;
    }

    nav {
      background-color: #e74c3c;
      padding: 10px;
      display: flex;
      justify-content: center;
      gap: 20px;
    }

    nav a {
      color: white;
      text-decoration: none;
      font-weight: bold;
    }

    .container {
      padding: 30px;
    }

    .card {
      background-color: white;
      border-radius: 8px;
      padding: 20px;
      margin-bottom: 20px;
      box-shadow: 0 2px 5px rgba(0,0,0,0.1);
    }

    footer {
      background-color: #c0392b;
      color: white;
      text-align: center;
      padding: 15px;
      position: fixed;
      width: 100%;
      bottom: 0;
    }

    button {
      background-color: #27ae60;
      color: white;
      padding: 10px 15px;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    button:hover {
      background-color: #1e8449;
    }
  </style>
</head>
<script>
  window.onload = function() {
    const urlParams = new URLSearchParams(window.location.search);
    if(urlParams.get('msg') === 'success') {
      alert("Se agregó correctamente");
      // Opcional: puedes limpiar la URL para que no vuelva a salir el alert
      history.replaceState(null, null, window.location.pathname);
    }
  }
</script>
<body>
  <header>
    <h1>Sistema de Ventas - Restaurante "La Buena Mesa"</h1>
  </header>

  <nav>
    <a href="#">Pedidos</a>
    
  </nav>

  <div class="container">
    <div class="card">
      <h2>Registrar Nuevo Pedido</h2>
      <form action = "pedido" method = "post">
        <label>Cliente:</label><br/>
        <input type="text" name="txtcliente" placeholder="Nombre del cliente" /><br/><br/>

        <label>Plato:</label><br/>
        <select name = selecPlato>
          <option>Arroz con Pollo</option>
          <option>Ceviche</option>
          <option>Lomo Saltado</option>
        </select><br/><br/>

        <label>Cantidad:</label><br/>
        <input type="number" name="numcantidad" min="1" /><br/><br/>

        <input type="submit" name = "btnAgre" value ="Agregar Pedido"/>
      </form>
    </div>

    <div class="card">
      <h2>Resumen de Ventas</h2>
      <p>Total del Dia: S/. 0</p>
      <p>Pedidos Atendidos: 0</p>
    </div>
  </div>

  <footer>
    &copy; 2025 Restaurante La Buena Mesa | Sistema de Ventas desarrollado por Grupo 3
  </footer>
</body>
</html>

