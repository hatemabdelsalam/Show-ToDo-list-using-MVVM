package com.hatem.todolist.home.model

data class UserDTO(val id: Long?, val name: String?, val userName: String?, val email: String?, val website:String, val address:AddressUserDTO, val geo:GeoUserDTO)

data class AddressUserDTO(val street:String, val suite:String,val city:String,val zipcode:String)

data class GeoUserDTO(val lat: String, val lng: String)
