export interface Product {
    id: number;
    name: string;
    price: number;
    quantity:number;
    image: string;
    liked: boolean;
    description: string;
}

export interface ProductState {
    products: Product[],
    loading: boolean
}