 // Escuchar evento click en los enlaces
  var links = document.querySelectorAll('.nav-link');
  links.forEach(function(link) {
    link.addEventListener('click', function() {
      // Quitar la clase 'selected' de todas las opciones
      links.forEach(function(otherLink) {
        otherLink.classList.remove('selected');
      });
      // Agregar la clase 'selected' a la opción seleccionada
      link.classList.add('selected');
    });
  });