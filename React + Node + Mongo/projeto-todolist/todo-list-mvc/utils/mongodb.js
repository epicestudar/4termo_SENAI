import mongoose from "mongoose";

const connectMongo = async () => {
    mongoose.connect(process.env.DATABASE_URL).then(() => console.log("Mongo conectado")).catch(err=>console.log(err));
}

export default connectMongo;