<?php

use Illuminate\Support\Facades\Schema;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Database\Migrations\Migration;

class CreateSuatChieusTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('suatchieu', function (Blueprint $table) {
            $table->increments('id');
            $table->time('GioChieu');
            $table->integer('Trangthai')->unsigned();
            $table->integer('lichchieu_id')->unsigned()->index();
            $table->timestamps();
            $table->softDeletes();

            $table->foreign('lichchieu_id')->references('id')->on('lichchieu');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('suatchieu');
    }
}