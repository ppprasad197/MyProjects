export interface Product {
    id: number;
    name: string;
    price: number;
    image: string;
    liked: boolean;
    description: string;
}

export interface ProductState {
    products: Product[],
    loading: boolean
}