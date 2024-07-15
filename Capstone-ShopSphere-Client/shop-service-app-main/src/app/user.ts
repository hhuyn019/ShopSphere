export interface User{
    id: number,
    name: {
        firstName: string,
        middleName:string,
        lastName:string
    },
    email: string,
    address: {
        city: string,
        street: string,
        houseNumber: number,
        zipcode: string
    },
    phoneNumber: string,
    role: string
}