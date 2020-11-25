<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreatePhimsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('phim', function (Blueprint $table) {
            $table->increments('id');
            $table->string('Tenphim');
            $table->string('Hinhanh')->unique();
            $table->integer('Diem')->unsigned()->default(0);
            $table->text('Mota');
            $table->string('Trailer');
            $table->time('ThoiLuong');
            $table->integer('dinhdang_id')->unsigned()->index();
            $table->integer('trangthai_id')->unsigned()->index();
            $table->integer('theloai_id')->unsigned()->index();
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('dinhdang_id')->references('id')->on('DinhDangPhim');
            $table->foreign('trangthai_id')->references('id')->on('TrangThaiPhim');
            $table->foreign('theloai_id')->references('id')->on('TheLoaiPhim');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('phim');
    }
}
