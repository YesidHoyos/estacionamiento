insert into ticket_vehiculo (cilindraje, estado, fecha_ingreso, fecha_salida, placa, tipo_vehiculo, id) values (400, 'I', sysdate, null, 'ABC123', 1, hibernate_sequence.nextval);
commit;